package com.huang.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by sccy on 2018/2/13/0013.
 */
@Service
@Scope("prototype")//默认为singleton
public class PrototypeService {
}
