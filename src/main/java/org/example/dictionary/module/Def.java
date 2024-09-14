package org.example.dictionary.module;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Def {

    public String text;
    public String pos;
    public String ts;
    public ArrayList<Tr> tr;

}





