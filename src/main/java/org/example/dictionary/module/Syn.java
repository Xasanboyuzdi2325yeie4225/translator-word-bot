package org.example.dictionary.module;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Syn{
    public String text;
    public String pos;
    public int fr;
    public String gen;
}
