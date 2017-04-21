/**   
 * Copyright © 2017 SOF . Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: 
 * com.sof.sales.core.Lines 
 * @author: 
 * aaron   
 * @date: 
 * 2017年4月16日 下午3:22:55 
 */
package com.sof.sales.core.line;

import java.io.InputStream;
import java.nio.file.FileSystem;
import java.util.Collection;
import java.util.Set;

import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;

public class Lines {

	public static Collection<String> openGZip(Collection<String> open,FileSystem fs) {
		InputStream in = null;
		//fs.open
		CompressionCodecFactory factory = new CompressionCodecFactory(null);
		/*in = CompressionCodecFactory.createInputStream(local.open(input));
        out = local.create(new Path(outputUri));*/
		return open;
	}
	
}
