package org.example.dictionary.module;

import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationItem {
    private String text;
    private String pos;
    private String gen;
    private String ts;
    private int fr;
    private List<Translation> syn;
    private List<Translation> mean;
    private String asp;

    // Getters and setters
}

