
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class QueryRestController {

    // GET /api/v1/query?published={bool}
    //                  &editable={bool}
    //                  &author={str}
    //                  &keywords={str}
    //                  &page={int min 0}
    //                  &items={int min 5}

    // GET api/v1/{author}/query?

}