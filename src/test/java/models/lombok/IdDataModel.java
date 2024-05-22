package models.lombok;

import lombok.Data;

import java.util.List;

@Data
public class IdDataModel {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<IdModelDataItem> data;
   SupportModel support;


}
