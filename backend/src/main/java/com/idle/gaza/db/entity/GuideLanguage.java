package com.idle.gaza.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class GuideLanguage {

    @Id
    @Column(name = "guide_language_id")
    private int languageId;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @Column(name = "lang_code")
    private String langCode;

    @Builder
    public GuideLanguage(int languageId, Guide guide, String langCode) {
        this.languageId = languageId;
        this.guide = guide;
        this.langCode = langCode;
    }

}
