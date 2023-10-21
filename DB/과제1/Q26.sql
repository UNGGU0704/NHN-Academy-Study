select koreantitle
from movie
order by BoxOfficeWWGross + BoxOfficeUSGross desc
limit 10;