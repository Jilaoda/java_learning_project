/*
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-31 17:33:03
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-31 17:33:08
 * @FilePath: \vue-admin-template-tag-3.11.0\src\api\user.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/utils/request'

export function userList(query) {
    return request({
      url: '/user/list',
      method: 'post',
      data: query
    })
}

export function addUser(data) {
    return request({
      url: '/user/create',
      method: 'post',
      data
    })
}

export function updateUser(data) {
    return request({
      url: '/user/update',
      method: 'post',
      data
    })
}

export function deleteUser(id) {
    return request({
      url: '/user/delete',
      method: 'post',
      params: { id }
    })
}
