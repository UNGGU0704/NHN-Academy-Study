select title, koreantitle, releaseYear, RunningTime
from movie
where RunningTime = (select max(RunningTime)
					  from movie
                      where MovieID in (select distinct MovieID
										from appear
                                        where (personid in (SELECT personid FROM DatamotionMovieDatabase.person where koreanname = '톰 행크스')) 
												and
                                                (roleid in (select roleid from role where RoleKorName = '배우'))));