
select Name
from person
where personid =
(select a.personid
from movie as m join appear as a on m.MovieID = a.MovieID
where a.roleid = 2
group by PersonID limit 1)

