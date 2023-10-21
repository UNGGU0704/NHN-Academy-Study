select location
from awardyear
group by Location
order by count(location) desc
limit 1;