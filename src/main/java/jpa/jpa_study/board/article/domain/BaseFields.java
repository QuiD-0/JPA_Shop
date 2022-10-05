package jpa.jpa_study.board.article.domain;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@ToString
@Getter
@MappedSuperclass
@NoArgsConstructor
public class BaseFields {

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String createdBy;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public BaseFields(String createdBy) {
        this.createdBy = createdBy;
    }
}
