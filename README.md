# fastclone<br>
轻量级Java对象高效克隆框架，提供高效的深克隆(非Object->序列化->Object)、浅克隆。<br>
# Demo
User user = new User();<br>
FastClone fastClone = new FastClone();<br>
// 深克隆<br>
User clone = fastClone.clone(user);<br>
// 浅克隆<br>
User clone = fastClone.cloneShallow(user);<br>
