package jpa.jpa_study.jpa.twitterAPI;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.endpoints.AdditionalParameters;
import io.github.redouane59.twitter.dto.tweet.TweetList;
import io.github.redouane59.twitter.dto.tweet.TweetV2;
import io.github.redouane59.twitter.dto.user.UserV2;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class APIService {

    private final Environment env;

    //    @Scheduled(cron = "0 0/1 * * * ?")
    public void TestTwitterLoading() {
        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken(env.getProperty("twitterAccessToken"))
                .accessTokenSecret(env.getProperty("twitterAccessTokenSecret"))
                .apiKey(env.getProperty("twitterApiKey"))
                .apiSecretKey(env.getProperty("twitterApiSecret"))
                .build());

        LocalDateTime endLocalDateTime = LocalDateTime.now();
        LocalDateTime startLocalDateTime = endLocalDateTime.minusMinutes(2);
        AdditionalParameters additionalParameters = AdditionalParameters.builder().startTime(startLocalDateTime).endTime(endLocalDateTime).build();

        UserV2 userV2 = twitterClient.getUserFromUserName("TicketOpen"); //@를 제외한 아이디
        System.out.println("아이디 로딩 체크");
        System.out.println("아이디 : " + userV2.getId());

        TweetList tweetList = twitterClient.getUserTimeline(userV2.getId(), additionalParameters);
        System.out.println("트윗 로딩 체크");
        System.out.println("가져온 트윗 수 : " + tweetList.getData().size());
        for (TweetV2.TweetData tweet : tweetList.getData()) {
            if (tweet.getText().contains("블루스퀘어")) {
                if (tweet.getText().contains("콘서트") || tweet.getText().contains("팬미팅") || tweet.getText().contains("어워즈")) {
                    continue;
                }
            } else {
                if (!tweet.getText().contains("뮤지컬") && !tweet.getText().contains("연극") && !tweet.getText().contains("극단"))
                    continue;
            }
            System.out.println("Id : " + tweet.getId());
            System.out.println("CreatedAt : " + tweet.getCreatedAt());
            System.out.println("text : " + tweet.getText());
            System.out.println("==============================");

        }
    }
}
