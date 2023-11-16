select koreantitle
from movie
where movieid in (select movieid
	from appear
	where personid = (SELECT personid FROM DatamotionMovieDatabase.person where koreanname = '한스 짐머'))
    and 
   movieid in (select movieid
	from appear
	where appearid in (SELECT distinct(appearid) FROM DatamotionMovieDatabase.awardinvolve))
    


