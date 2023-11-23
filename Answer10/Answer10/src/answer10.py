import pytest
from selenium import webdriver

@pytest.fixture
def browser():
    driver = webdriver.Chrome(executable_path='C:\Users\frank.DESKTOP-2DFF4LO\OneDrive\Desktop\SDET\chromedriver.exe')
    yield driver
    driver.quit()

def test_w3schoolslogo(browser):
    browser.get("https://www.w3schools.com/")
    logo = browser.find_element_by_xpath("//a[@id='w3-logo']")
    assert logo.is_displayed(), "W3Schools logo is not present."