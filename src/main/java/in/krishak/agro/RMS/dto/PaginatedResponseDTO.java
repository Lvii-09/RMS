package in.krishak.agro.RMS.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponseDTO<T> {

    private List<T> data;
    private int pageSize;
    private int pageNumber;
    private boolean isNextPageAvailable;

    public PaginatedResponseDTO(List<T> data, int pageSize, int pageNumber, long sliceCount) {
        this.data = data;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.isNextPageAvailable = sliceCount > pageSize;
    }
}
