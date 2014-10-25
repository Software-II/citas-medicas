$(function() {
                $('#activatorAdd').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxAdd').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseAdd').click(function(){
                    $('#boxAdd').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });

                $('.activatorEdit').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxEdit').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseEdit').click(function(){
                    $('#boxEdit').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });


                /*SETTING*/


                /**AGREGAR CATEGORIA**/
                $('#activatorAddCategoria').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxAddCategoria').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseAddCategoria').click(function(){
                    $('#boxAddCategoria').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });
                /**MODIFICAR CATEGORIA**/
                $('.activatorEditCategoria').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxEditCategoria').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseEditCategoria').click(function(){
                    $('#boxEditCategoria').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });

                /**AGREGAR TIPOTRABAJO**/
                $('#activatorAddTipo').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxAddTipo').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseAddTipo').click(function(){
                    $('#boxAddTipo').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });
                /**MODIFICAR TIPO TRABAJO**/
                $('.activatorEditTipo').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxEditTipo').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseEditTipo').click(function(){
                    $('#boxEditTipo').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });

                /**AGREGAR MONEDA**/
                $('#activatorAddMoneda').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxAddMoneda').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseAddMoneda').click(function(){
                    $('#boxAddMoneda').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });
                /**MODIFICAR MONEDA**/
                $('.activatorEditMoneda').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxEditMoneda').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseEditMoneda').click(function(){
                    $('#boxEditMoneda').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });






                 /*$('#activatorAddSet').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxAddSet').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseAddSet').click(function(){
                    $('#boxAddSet').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });


                $('.activatorEditSet').click(function(){
                    $('#overlay').fadeIn('fast',function(){
                        $('#boxEditSet').animate({'top':'20%'},500);
                    });
                });
                $('#boxcloseEditSet').click(function(){
                    $('#boxEditSet').animate({'top':'-100%'},500,function(){
                        $('#overlay').fadeOut('fast');
                    });
                });
                */


    /*End*/});