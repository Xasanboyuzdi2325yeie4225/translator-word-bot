package org.example.dictionary.module;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tr{
    public String text;
    public String pos;
    public String gen;
    public int fr;
    public ArrayList<Syn> syn;
    public ArrayList<Mean> mean;
    public String asp;
}
