select  distinct p.personid, p.koreanname
from person as p
	join appear as a on p.personid = a.personid
where a.roleid in (select roleid from role where rolekorname = '배우')
	 and 
     a.movieid in (select movieid from moviegenre where genreid in (select genreid from genre where genrename = 'drama'))
	 and
     a.personid not in ( select p.personid
						from person as p
						join appear as a on p.personid = a.personid
						where a.roleid in (select roleid from role where rolekorname = '배우')
						 and 
						 a.movieid in (select movieid from moviegenre where genreid in (select genreid from genre where genrename = 'horror')));
                         
                         

