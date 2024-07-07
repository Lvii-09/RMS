package in.krishak.agro.RMS.models;

import jakarta.persistence.*;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cow_details")
public class CattleDetailDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "species")
    private String species;

    @Column(name = "deworming")
    private Boolean deworming;

    @Column(name = "days_in_milk")
    private Integer daysInMilk;

    @CreationTimestamp
    @Builder.Default
    @Column(name = "created_at")
    private Instant createdAt = Instant.now();;

    @UpdateTimestamp
    @Builder.Default
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

}
