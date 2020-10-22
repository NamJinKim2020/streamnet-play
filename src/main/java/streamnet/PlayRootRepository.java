package streamnet;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PlayRootRepository extends PagingAndSortingRepository<PlayRoot, Long>{

    Optional<PlayRoot> findByContentsId(Long contentsId);

}