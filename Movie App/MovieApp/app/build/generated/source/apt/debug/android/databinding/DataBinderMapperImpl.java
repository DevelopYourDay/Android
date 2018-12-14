package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.e5813.movieapp.DataBinderMapperImpl());
  }
}
