select koreantitle
from movie
where BoxOfficeWWGross + BoxOfficeUSGross > 1000000000 
	  and budget < 100000000