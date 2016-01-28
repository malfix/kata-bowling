class PagesRangeTest < Test::Unit::TestCase
  def test_below_max_pages
    assert_equal(1..10, PagesRange.with_total_pages(11).at_page(1))
    assert_equal(1..10, PagesRange.with_total_pages(11).at_page(6))
  end

  def test_overtake_max_pages
    assert_equal(1..1, PagesRange.with_total_pages(1).at_page(1))
    assert_equal(2..11, PagesRange.with_total_pages(11).at_page(7))
    assert_equal(2..11, PagesRange.with_total_pages(11).at_page(8))
    assert_equal(11..20, PagesRange.with_total_pages(20).at_page(20))
    assert_equal(9..18, PagesRange.with_total_pages(200).at_page(14))
  end

  def test_links_to_show_are_less_than_max
    assert_equal(1..3, PagesRange.with_total_pages(3).at_page(2))
  end
end
# kata-bowling
