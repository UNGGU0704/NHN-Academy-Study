select koreanname
from person
where personid = (select a.personid, m.BoxOfficeWWGross + m.BoxOfficeUSGross
				  from appear as a 
					join movie as m on a.movieid = m.movieid
				  order by (m.BoxOfficeWWGross + m.BoxOfficeUSGross) desc
                  limit 1);
    
