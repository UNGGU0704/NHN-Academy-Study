select koreantitle
from movie
where  BoxOfficeUSGross + BoxOfficeWWGross = (select MAX(BoxOfficeUSGross + BoxOfficeWWGross) from movie where GradeInKoreaID = 4 );