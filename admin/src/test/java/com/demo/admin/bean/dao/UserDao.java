/**
 * FileName: UserDao
 * Author:   Danny
 * Date:     2021/12/14 19:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.admin.bean.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Danny
 * @create 2021/12/14
 * @since 1.0.0
 */
public class UserDao {
  private static Map<String, String> hashMap = new HashMap<String,String>();

  static {
    hashMap.put("10001", "aaaaa");
    hashMap.put("10002", "ccccc");
    hashMap.put("10003", "ddddd");
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }
}