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
@Table(name = "admin_user")
public class AdminUser implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Builder.Default
    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @UpdateTimestamp
    @Builder.Default
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();
}
