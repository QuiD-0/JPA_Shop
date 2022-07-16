package jpa.jpa_study.twitterAPI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.endpoints.AdditionalParameters;
import io.github.redouane59.twitter.dto.tweet.TweetList;
import io.github.redouane59.twitter.dto.tweet.TweetV2;
import io.github.redouane59.twitter.dto.user.UserV2;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDateTime;

@Service
public class APIService {

    Reader reader = new FileReader("secret.json");
    Gson gson = new Gson();
    JsonObject obj = gson.fromJson(reader, JsonObject.class);

    private TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
            .accessToken("")
            .accessTokenSecret("")
            .apiKey("")
            .apiSecretKey("")
            .build());

    public APIService() throws FileNotFoundException {}

    public void TestTwitterLoading() {
        LocalDateTime endLocalDateTime = LocalDateTime.now();
        LocalDateTime startLocalDateTime = endLocalDateTime.minusDays(7);
        // 파라메터 설정
        AdditionalParameters additionalParameters = AdditionalParameters.builder().startTime(startLocalDateTime).endTime(endLocalDateTime).build();

        UserV2 userV2 = twitterClient.getUserFromUserName("TicketOpen"); //@를 제외한 아이디
        System.out.println("아이디 로딩 체크");
        System.out.println("아이디 : " + userV2.getId());

        TweetList tweetList = twitterClient.getUserTimeline(userV2.getId(), additionalParameters);
        System.out.println("트윗 로딩 체크");
        System.out.println("가져온 트윗 수 : " + tweetList.getData().size());
        for (TweetV2.TweetData tweet : tweetList.getData()) {
            System.out.println("Id : " + tweet.getId());
            System.out.println("text : " + tweet.getText());
            System.out.println("==============================");
        }
    }
}

