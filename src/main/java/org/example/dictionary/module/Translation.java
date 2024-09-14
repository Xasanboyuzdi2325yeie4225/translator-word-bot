package org.example.dictionary.module;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Translation {
    private String text;
    private String pos;
    private String ts;
    private List<TranslationItem> tr;

    // Getters and setters
}
