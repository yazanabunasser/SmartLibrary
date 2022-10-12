package com.example.smartlibrary.dto.mapper;

import com.example.smartlibrary.Model.Book;
import com.example.smartlibrary.Model.Manager;
import com.example.smartlibrary.Model.ShelfBoy;
import com.example.smartlibrary.dto.model.BookDTO;
import com.example.smartlibrary.dto.model.ManagerDTO;
import com.example.smartlibrary.dto.model.ShelfBoyDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {


    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    static {
        mapperFactory.classMap(Book.class, BookDTO.class).customize(
                new CustomMapper<>() {
                    @Override
                    public void mapAtoB(Book book, BookDTO bookDTO, MappingContext context) {
                        super.mapAtoB(book, bookDTO, context);
                        bookDTO.setAvailable(book.getStock() - book.getSales());
                    }

                }
        ).byDefault().register();

        mapperFactory.classMap(Book.class, BookDTO.class)
                .field("id", "id")
                .field("name", "name")
                .field("author", "author")
                .field("size", "size")
                .field("price", "price")
                .field("stock", "stock")
                .field("sales", "sales")
                .field("shelfBoy.id", "shelfBoyDTO.id")
                .field("shelfBoy.name" , "shelfBoyDTO.name")
                .field("shelfBoy.gender" , "shelfBoyDTO.gender")
                .field("shelfBoy.email" , "shelfBoyDTO.email")
                .field("shelfBoy.workDepartment" , "shelfBoyDTO.workDepartment")
                .field("shelfBoy.manager.id", "shelfBoyDTO.managerDTO.id")
                .field("shelfBoy.manager.name", "shelfBoyDTO.managerDTO.name")
                .field("shelfBoy.manager.gender", "shelfBoyDTO.managerDTO.gender")
                .field("shelfBoy.manager.email", "shelfBoyDTO.managerDTO.email")



                .register();

        mapperFactory.classMap(Manager.class, ManagerDTO.class)
                .customize(
                        new CustomMapper<Manager, ManagerDTO>() {
                            @Override
                            public void mapAtoB(Manager manager, ManagerDTO managerDTO, MappingContext context) {
                                super.mapAtoB(manager, managerDTO, context);
                                List<ShelfBoyDTO> shelfBoyDTOS = new ArrayList<>();
                                manager.getShelfBoy().stream().forEach(
                                        shelfBoyEntity -> {
                                            ShelfBoyDTO shelfBoyDTO = new ShelfBoyDTO(
                                                    shelfBoyEntity.getId(),
                                                    shelfBoyEntity.getName(),
                                                    shelfBoyEntity.getGender(),
                                                    shelfBoyEntity.getEmail(),
                                                    shelfBoyEntity.getWorkDepartment()
                                            );
                                            shelfBoyDTOS.add(shelfBoyDTO);
                                        }
                                );
                                managerDTO.setShelfBoyDTO(shelfBoyDTOS);
                            }
                        }
                ).byDefault().register();

        mapperFactory.classMap(ShelfBoy.class, ShelfBoyDTO.class)
                .field("id", "id")
                .field("name", "name")
                .field("gender", "gender")
                .field("email", "email")
                .field("workDepartment", "workDepartment")
                .field("manager.id", "managerDTO.id")
                .field("manager.name", "managerDTO.name")
                .field("manager.gender", "managerDTO.gender")
                .field("manager.email", "managerDTO.email")
                .customize(
                        new CustomMapper<ShelfBoy, ShelfBoyDTO>() {
                            @Override
                            public void mapAtoB(ShelfBoy shelfBoy, ShelfBoyDTO shelfBoyDTO, MappingContext context) {
                                super.mapAtoB(shelfBoy, shelfBoyDTO, context);
                                List<BookDTO> bookDTOS = new ArrayList<>();
                                shelfBoy.getBooks().stream().forEach(
                                        bookEntity -> {
                                            BookDTO bookDTO = new BookDTO(
                                                    bookEntity.getid(),
                                                    bookEntity.getName(),
                                                    bookEntity.getISPN(),
                                                    bookEntity.getAuthor(),
                                                    bookEntity.getSize(),
                                                    bookEntity.getPrice(),
                                                    bookEntity.getStock(),
                                                    bookEntity.getSales()
                                            );
                                            bookDTOS.add(bookDTO);
                                        }
                                );
                                shelfBoyDTO.setBookDTO(bookDTOS);
                            }
                        }
                ).byDefault().register();


    }

    public static <D, T> D map(T entity, Class<D> outClass) {
        MapperFacade modelMapper = mapperFactory.getMapperFacade();
        return modelMapper.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

}
