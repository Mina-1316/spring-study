package gdsc.edu.springstudy.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//JPA auditing
@Getter
@MappedSuperclass   // JPA Entity간의 상속 제어. 상속 필드를 column으로 인식하게 함
@EntityListeners(AuditingEntityListener.class)  // 이 엔티티에 Auditing 기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    // Date 대신 LocalDateTime 사용 이유
    // 1. Date는 thread-safe하지 않음
    // 2. Calander의 월 값 설계 결함
}
