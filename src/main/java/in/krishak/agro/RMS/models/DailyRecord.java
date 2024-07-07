package in.krishak.agro.RMS.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "daily_record")
public class DailyRecord implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "date", nullable = true)
    private Timestamp date;

    @Column(name = "dry_bait", nullable = true)
    private Integer dryBait;

    @Column(name = "green_bait", nullable = true)
    private Integer greenBait;

    @Column(name = "khal", nullable = true)
    private Integer khal;

    @Column(name = "churi", nullable = true)
    private Integer churi;

    @Column(name = "rest", nullable = true)
    private Integer rest;

    @Column(name = "krishak_feed", nullable = true)
    private Integer krishakFeed;

    @Column(name = "milk", nullable = true)
    private Integer milk;

    @Column(name = "fat", nullable = true)
    private Integer fat;

    @Column(name = "snf", nullable = true)
    private Integer snf;

    @Column(name = "gobar", nullable = true)
    private Integer gobar;

    @Column(name = "comment", nullable = true, length = 40)
    private String comment;

    @Column(name = "cattle_id")
    private Long cattleId;

    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
