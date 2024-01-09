Feature: Login functionality



  Scenario Outline: Login with multiple users for successful login

    Given Launch the application

    When Enter username "<username>" and password "<password>"

    Then Title validation "Swag Labs"

    Then Close the application

    Examples:

      | username | password |

      | standard_user | secret_sauce |

      | problem_user | secret_sauce |

      | performance_glitch_user | secret_sauce |

      | error_user | secret_sauce |

      | visual_user | secret_sauce |

      

  Scenario Outline: Login with user for unsuccessful login

    Given Launch the application

    When Enter username "<username>" and password "<password>"

    Then Error message validation

    Then Close the application

    Examples:

      | username | password |

      | locked_out_user | secret_sauce |

