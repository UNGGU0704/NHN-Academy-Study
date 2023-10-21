SELECT count(Name) 
from person
where personID in (select personID
							from appear
							where MovieID in ( select MovieID
												from movie
												where koreanTitle = '매트릭스') and roleID in (select roleID
																								from role
                                                                                                where RolekorName = '감독'
																									));