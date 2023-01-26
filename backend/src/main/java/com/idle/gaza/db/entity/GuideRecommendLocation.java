package com.idle.gaza.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "recommend")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideRecommendLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recommend_id")
    private Integer recommendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="guide_id")
    private Guide guide;

    private String name;

    private String address;

    @Column(name="category_code")
    private String categoryCode;

    private String picture;

    @Column(columnDefinition = "DECIMAL")
    private String latitude;

    @Column(columnDefinition = "DECIMAL")
    private String longitude;
}
