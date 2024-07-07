package in.krishak.agro.RMS.models;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
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
@Table(name = "user")
public class User implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Builder.Default
    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @UpdateTimestamp
    @Builder.Default
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

    @Override
    public User clone() {
        try {
            return  (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @PrePersist
    public void setExternalId() {
        this.externalId = UUID.randomUUID().toString();
    }

}
