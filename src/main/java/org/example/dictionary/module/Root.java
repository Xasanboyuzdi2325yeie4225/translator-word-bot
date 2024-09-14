package org.example.dictionary.module;

import lombok.*;

import java.util.ArrayList;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Root{
    public Head head;
    public ArrayList<Def> def;
}

