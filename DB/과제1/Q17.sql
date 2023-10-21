select title
from movie
where MovieID in (select MovieID
				  from moviegenre
                  where genreID in( (select GenreID from genre where genreName = 'Drama'))
							or
                           (select GenreId from genre where genreName = 'war'));