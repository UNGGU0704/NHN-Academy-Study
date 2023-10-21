select koreantitle
from movie
where budget = ( select MIN(Budget)
				 from movie
				 where budget != 0);