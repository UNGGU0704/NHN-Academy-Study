select avg(BoxOfficeWWGross + BoxOfficeUSGross)
from movie
where MovieID in (select MovieID
				  from moviegenre
                  where genreID in (select GenreID from genre where genreName = 'action'));