package cinema.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
