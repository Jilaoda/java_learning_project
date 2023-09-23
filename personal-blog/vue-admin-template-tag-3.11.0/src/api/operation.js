/*
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-31 16:32:22
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-31 21:09:01
 * @FilePath: \vue-admin-template-tag-3.11.0\src\api\operation.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/utils/request'

export function fetchLogList(query) {
	return request({
	url: '/log/operationLog/list',
	method: 'post',
	data: query
	})
}

export function fetchLoginLogList(query) {
  return request({
    url: '/log/loginOperationLog/list',
    method: 'post',
    data: query
  })
}
