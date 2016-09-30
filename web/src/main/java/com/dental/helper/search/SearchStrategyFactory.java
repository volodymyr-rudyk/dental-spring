package com.dental.helper.search;

import com.dental.service.SearchService;

/**
 * Created by vrudyk on 9/28/2016.
 */
public class SearchStrategyFactory {

  public static final String DELIMITER = " ";

  public static SearchStrategy getSearchStrategy(String input, SearchService searchService) {

    String[] filters = input.split(DELIMITER);
    int length = filters.length;
    switch (length){
      case 0: return new EmptySearchStrategy();
      case 1: return new OneNameSearchStrategy(filters[0], searchService);
      case 2: return new FirstLastNameSearchStrategy(filters[0], filters[1], searchService);
      default: return () -> null;
    }


  }
}
