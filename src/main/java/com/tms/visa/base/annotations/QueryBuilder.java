/**
 * 
 */
package com.tms.visa.base.annotations;

import com.tms.visa.base.enums.QueryType;

import java.lang.annotation.*;

/**
 * 类功能说明：
 * 
 * <p>Copyright: Copyright © 2012-2013 author.com Inc.</p>
 * <p>Company:</p>
 * @author
 * @date 2013-12-30 下午3:56:22
 * @version v1.0
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryBuilder {
	QueryType value();
}
