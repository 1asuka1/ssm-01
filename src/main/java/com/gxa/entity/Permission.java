package com.gxa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private  Integer id;
    private  String name;
    private String url;
    private String per;
    private String parent_id;
}
