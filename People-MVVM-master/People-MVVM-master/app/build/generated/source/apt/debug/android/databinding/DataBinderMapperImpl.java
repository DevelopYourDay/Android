package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.jhordan.people_mvvm.DataBinderMapperImpl());
  }
}
