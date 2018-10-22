
jQuery(document).ready(function(){

/* C A R O U S E L    P E L I C U L A S */

  var $ = jQuery;
  var $carousel = $('.carousel');

  if($carousel.find('.carousel-inner > .item').size() <= 1) {
    $carousel.find('.carousel-control').remove();
    $carousel.find('.carousel-indicators').remove();
  }

  $carousel.find('.carousel-inner > .item').each(function(i) {
    (i === 0) ? $carousel.find('.carousel-indicators').append("<li data-target='#"+
                                                              $carousel.attr('id')+
                                                              "' data-slide-to='"+i+
                                                              "' class='active'></li>"
    ) : $carousel.find('.carousel-indicators').append("<li data-target='#"+
                                                      $carousel.attr('id')+
                                                      "' data-slide-to='"+i+
                                                      "'></li>");
    var src = $(this).find('img').attr('src');

    if(src) {
      $(this).css('background','url('+src+')');
    }

/* C A R O U S E L    S E R I E S */

  var $ = jQuery;
  var $carousel2 = $('#Carousel2');

  if($carousel2.find('#carousel-inner2 > #item2').size() <= 1) {
    $carousel2.find('#carousel-control2').remove();
    $carousel2.find('#carousel-indicators2').remove();
  }

  $carousel2.find('#carousel-inner2 > #item2').each(function(i) {
    (i === 0) ? $carousel2.find('#carousel-indicators2').append("<li data-target='#"+
                                                              $carousel2.attr('id')+
                                                              "' data-slide-to='"+i+
                                                              "' class='active'></li>"
    ) : $carousel2.find('#carousel-indicators2').append("<li data-target='#"+
                                                      $carousel2.attr('id')+
                                                      "' data-slide-to='"+i+
                                                      "'></li>");
    var src = $(this).find('img').attr('src');

    if(src) {
      $(this).css('background','url('+src+')');
    }



  });

  $carousel.find('.carousel-inner > .item').first().addClass('active');

  $carousel2.find('#carousel-inner2 > #item2').first().addClass('active');
