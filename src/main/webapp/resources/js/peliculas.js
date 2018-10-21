jQuery(document).ready(function(){

/* P E L I C U L A S */

  var $ = jQuery;
  var $lista = $('.pagination');

  if($carousel.find('.pagination > .li').size() <= 1) {
    $carousel.find('.menos').remove();
    $carousel.find('.mas').remove();
  }

$lista.find('.li > a').first().addClass('active');
