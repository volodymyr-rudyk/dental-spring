package com.dental.helper.search;

import com.dental.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vrudyk on 9/28/2016.
 */
@Component
public class SearchStrategyFactory {

  private static final String DELIMITER = ",";

  @Autowired
  private SearchService searchService;

  public SearchStrategy getSearchStrategy(String input) {
    String[] filters = input.split(DELIMITER);
    int length = filters.length;
    switch (length){
      case 0: return new EmptySearchStrategy();
      case 1: return new OneNameSearchStrategy(filters[0], searchService);
      case 2: return new FirstLastNameSearchStrategy(filters[0], filters[1], searchService);
      default: return new EmptySearchStrategy();
    }
  }
}
