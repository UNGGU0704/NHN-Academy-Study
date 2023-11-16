SELECT Name
from person
where personID in (select personID
							from appear
							where MovieID in ( select MovieID
												from movie
												where koreanTitle = '글래디에이터') and roleID in (select roleID
																								from role
                                                                                                where RolekorName = '작곡'
																									));